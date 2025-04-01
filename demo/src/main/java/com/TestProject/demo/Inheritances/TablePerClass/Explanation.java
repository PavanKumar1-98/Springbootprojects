package com.TestProject.demo.Inheritances.TablePerClass;

public class Explanation {
    /*
     Everything is same for mappedsuper class and Table per class only difference is if we have two subclasses
     in parent class we will keep it as GenerationType.Identity so for subclasses new id sequence will be gen
     erated for each one.

     But for Table per class in parent table we will keep GenerationType.AUTO so for all subclasses unique ids will
     be generated but in mapped super class each table we will have unique.

     What Happens in Table-per-Class (InheritanceType.TABLE_PER_CLASS)?
When you use Table-per-Class, the User class IS an entity and serves as the parent class in an inheritance hierarchy. Each subclass (TA, Mentor) gets its own table, but these tables include all fields inherited from the User class.

Example
Parent Class (User):

java
Copy code
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // Unique for all subclasses
    private Long id;
    private String name;

    // Getters and Setters
}
TA Class:

java
Copy code
import jakarta.persistence.Entity;

@Entity
public class TA extends User {
    private String taName;

    // Getters and Setters
}
Mentor Class:

java
Copy code
import jakarta.persistence.Entity;

@Entity
public class Mentor extends User {
    private String mentorName;

    // Getters and Setters
}
Database Schema (with Table-per-Class)
TA Table:

id	name	taName
101	Alice	TA Math
102	Bob	TA Science
Mentor Table:

id	name	mentorName
103	Carol	Mentor Java
104	Dave	Mentor Python
Key Points:

The id column is unique across all tables because it’s managed by the User class. For example:
Alice in the TA table has id = 101.
Carol in the Mentor table has id = 103.
The id values for TA and Mentor are not independent but come from the same sequence or table generator.
Polymorphic queries are possible because User is an entity.
Core Differences
Aspect	@MappedSuperclass	Table-per-Class (InheritanceType.TABLE_PER_CLASS)
Table for Parent	No table for User.	No table for User, but it’s an entity and manages id.
Table for Subclasses	Each subclass has its own table, independent of parent.	Each subclass has its own table, but inherits fields from the parent.
ID Generation	Separate and independent for each subclass.	Shared across subclasses (managed by the parent entity).
Polymorphic Queries	Not possible (parent is not an entity).	Possible, as User is an entity.
Data Duplication	No data duplication (fields only in subclass tables).	Some duplication of fields across subclass tables.
Which ID Scenario Fits Better?
@MappedSuperclass Example:

TA IDs: 1, 2, 3...
Mentor IDs: 1, 2, 3... (independent of TA IDs).
Table-per-Class Example:

TA IDs: 101, 102, 103...
Mentor IDs: 104, 105, 106... (unique across all subclasses).
When to Use Each?
@MappedSuperclass:

When you want separate, independent tables for subclasses without any inheritance hierarchy.
Subclass tables manage their own primary keys independently.
Table-per-Class:

When you want a shared inheritance hierarchy with unique IDs across all subclasses.
Polymorphic queries (e.g., querying all User entities) are needed.
Would you like to explore these scenarios with specific database configurations or more detailed SQL examples?






You said:
How can we query User in Table per class if that is not an entity
ChatGPT said:
ChatGPT
In Table-per-Class inheritance (InheritanceType.TABLE_PER_CLASS), the parent class is an entity, which allows querying the parent class (User in this case) directly. This is a key feature of Table-per-Class compared to @MappedSuperclass. Let me clarify:

Parent Class in Table-per-Class Is an Entity
In Table-per-Class:

The parent class (User) is annotated with @Entity.
Subclasses (TA and Mentor) inherit from User and define their additional fields.
You can write polymorphic queries directly on the parent class, and JPA will combine data from all subclass tables using a UNION.
Querying User in Table-per-Class
Here’s how you can query User:

Polymorphic Query
java
Copy code
List<User> users = entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
How Does It Work Internally?
When you query the User entity:

JPA generates a SQL query that performs a UNION on all the subclass tables (TA and Mentor in this case).
Each row is mapped to the correct subclass based on the table it originates from.
SQL Example
For the User query, JPA will generate something like this:

sql
Copy code
SELECT id, name, NULL as ta_name, 'TA' as DTYPE FROM TA
UNION
SELECT id, name, mentor_name, 'Mentor' as DTYPE FROM Mentor;
Here:

The DTYPE column (discriminator column) helps JPA determine the subclass (TA or Mentor).
Columns that don’t exist in a particular table are filled with NULL (e.g., ta_name in Mentor).
Returned Results
If your database has the following data:

TA Table:

id	name	ta_name
1	Alice	TA Math
Mentor Table:

id	name	mentor_name
2	Bob	Java
The query SELECT u FROM User u will return:

id	name	ta_name	mentor_name	DTYPE
1	Alice	TA Math	NULL	TA
2	Bob	NULL	Java	Mentor
In Java:

java
Copy code
for (User user : users) {
    if (user instanceof TA) {
        System.out.println("TA: " + user.getName());
    } else if (user instanceof Mentor) {
        System.out.println("Mentor: " + user.getName());
    }
}
Why Can't You Query User in @MappedSuperclass?
With @MappedSuperclass:

The parent class (User) is not an entity.
It exists only as a blueprint, and no table is created for it.
Subclasses (TA and Mentor) are completely independent, so polymorphic queries are not possible.
Key Takeaway
In Table-per-Class, you can query the parent class (User) because it is an entity. The query retrieves data from all subclass tables using a UNION. This behavior is not possible with @MappedSuperclass since the parent class is not an entity and has no associated table.

Would you like to see how to configure the DTYPE column or further explore polymorphic queries?











     */
}
