package com.training.employee.dao.impl;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.training.employee.dao.EmployeeDao;
import com.training.employee.model.Employee;
import com.training.employee.util.HibernateUtil;

public class EmployeeDaoImpl implements EmployeeDao {
    @Override
    public List<Employee> findAll() {
        return query("from Employee", Employee.class);
    }

    @Override
    public Employee findById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.find(Employee.class, id);
        }
    }

    @Override
    public List<Employee> findByDepartment(String department) {
        return query("from Employee e where e.department = :department", Employee.class,
                q -> q.setParameter("department", department));
    }

    @Override
    public List<Employee> salaryGreaterThan(BigDecimal amount) {
        return query("from Employee e where e.salary > :amount", Employee.class, q -> q.setParameter("amount", amount));
    }

    @Override
    public List<Employee> salaryBetween(BigDecimal low, BigDecimal high) {
        return query("from Employee e where e.salary between :low and :high", Employee.class, q -> {
            q.setParameter("low", low);
            q.setParameter("high", high);
        });
    }

    @Override
    public List<Employee> nameContains(String text) {
        return query("from Employee e where lower(e.name) like :text", Employee.class,
                q -> q.setParameter("text", "%" + text.toLowerCase() + "%"));
    }

    @Override
    public List<Employee> inDepartments(List<String> departments) {
        return query("from Employee e where e.department in :departments", Employee.class,
                q -> q.setParameter("departments", departments));
    }

    @Override
    public List<Employee> notInDepartments(List<String> departments) {
        return query("from Employee e where e.department not in :departments", Employee.class,
                q -> q.setParameter("departments", departments));
    }

    @Override
    public List<Employee> orderBySalaryDesc() {
        return query("from Employee e order by e.salary desc", Employee.class);
    }

    @Override
    public List<Employee> orderByName() {
        return query("from Employee e order by e.name asc", Employee.class);
    }

    @Override
    public List<Employee> itSalaryGreaterThan(BigDecimal amount) {
        return query("from Employee e where e.department = :department and e.salary > :amount", Employee.class, q -> {
            q.setParameter("department", "IT");
            q.setParameter("amount", amount);
        });
    }

    @Override
    public List<String> distinctDepartments() {
        return query("select distinct e.department from Employee e order by e.department", String.class);
    }

    @Override
    public List<String> distinctDesignations() {
        return query("select distinct e.designation from Employee e order by e.designation", String.class);
    }

    @Override
    public Object[] salaryStatistics() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(
                    "select count(e), avg(e.salary), max(e.salary), min(e.salary), sum(e.salary) from Employee e",
                    Object[].class).getSingleResult();
        }
    }

    @Override
    public List<Object[]> employeeCountByDepartment() {
        return query("select e.department, count(e) from Employee e group by e.department order by e.department",
                Object[].class);
    }

    @Override
    public List<Object[]> departmentsWithAverageSalaryAbove(BigDecimal amount) {
        return query("select e.department, avg(e.salary) from Employee e group by e.department having avg(e.salary) > :amount",
                Object[].class, q -> q.setParameter("amount", amount));
    }

    @Override
    public List<Object[]> nameDepartmentSalaryProjection() {
        return query("select e.name, e.department, e.salary from Employee e order by e.id", Object[].class);
    }

    @Override
    public List<Employee> topHighestPaid(int count) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Employee e order by e.salary desc", Employee.class)
                    .setMaxResults(count).getResultList();
        }
    }

    @Override
    public List<Employee> salaryAboveOverallAverage() {
        return query("from Employee e where e.salary > (select avg(e2.salary) from Employee e2)", Employee.class);
    }

    @Override
    public List<Employee> salaryAboveDepartmentAverage() {
        return query("from Employee e where e.salary > "
                + "(select avg(e2.salary) from Employee e2 where e2.department = e.department)", Employee.class);
    }

    @Override
    public int increaseDepartmentSalary(String department, BigDecimal percentage) {
        return executeUpdate("update Employee e set e.salary = e.salary * (1 + :percentage) where e.department = :department",
                q -> {
                    q.setParameter("percentage", percentage.divide(BigDecimal.valueOf(100)));
                    q.setParameter("department", department);
                });
    }

    @Override
    public int deleteByExperienceLessThan(int years) {
        return executeUpdate("delete from Employee e where e.experience < :years", q -> q.setParameter("years", years));
    }

    private <T> List<T> query(String hql, Class<T> type) {
        return query(hql, type, q -> {});
    }

    private <T> List<T> query(String hql, Class<T> type, QuerySetup setup) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            var query = session.createQuery(hql, type);
            setup.apply(query);
            return query.getResultList();
        }
    }

    private int executeUpdate(String hql, MutationSetup setup) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                var query = session.createMutationQuery(hql);
                setup.apply(query);
                int affected = query.executeUpdate();
                transaction.commit();
                return affected;
            } catch (RuntimeException exception) {
                transaction.rollback();
                throw exception;
            }
        }
    }

    @FunctionalInterface
    private interface QuerySetup {
        void apply(org.hibernate.query.Query<?> query);
    }

    @FunctionalInterface
    private interface MutationSetup {
        void apply(org.hibernate.query.MutationQuery query);
    }
}
