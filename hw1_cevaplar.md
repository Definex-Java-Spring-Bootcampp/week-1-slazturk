1)
a) Spring Framework: Spring açık kaynak kodlu bir framework’tür. Bünyesinde Spring JDBC, Spring MVC, Spring Security, Spring AOP, Spring ORM, Spring Test gibi modülleri içerir. Spring Framework IoC (Inversion of Control) yazılım tasarım prensibini temel alır, Dependency Injection yapılmasını sağlar.[1] Web uygulamaların geliştirilmesinde ve mikroservis yazılımlarında kullanılabilir.[2]
Spring Boot ise Spring’i temel alan bir framework’tür.

Spring Boot kod parçası örneği;
-----------------------------------------------
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloWorldApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloWorldApplication.class, args);
    }
}
-----------------------------------------------
b) Hibernate: Hibernate, veritabanı işlemlerinde kullanılan bir framework'tür. ORM (Object Relational Mapping) aracı olarak kullanılır. ORM, uygulamamızdaki nesnelerle ilişkisel veritabanları arasında bağ kurmamızı sağlayan bir yapıdır. Yerel SQL sorguları yazmadan verileri saklamayı, almayı ve değiştirmeyi kolaylaştırır.

-----------------------------------------------
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    // Other properties, getters, and setters
}
-----------------------------------------------

-----------------------------------------------
Session session = sessionFactory.openSession();
Transaction tx = session.beginTransaction();

List<Employee> employees = session.createQuery("FROM Employee", Employee.class).list();

tx.commit();
session.close();
//[3]
-----------------------------------------------

KAYNAKÇA
[1] https://www.turing.com/kb/spring-vs-spring-boots-best-web-apps
[2] https://hackr.io/blog/java-frameworks
[3] https://medium.com/thefreshwrites/exploring-the-most-common-java-libraries-frameworks-6c7ae547d23c
