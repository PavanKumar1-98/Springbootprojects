package com.TestProject.demo.Inheritances;

public class SingleTable {

    /*

    Sure! The Single Table Inheritance strategy in JPA is a way of mapping inheritance hierarchies to a single table in the database. All the entities in the inheritance hierarchy will share the same table, and a discriminator column is used to differentiate between different types of entities.

Single Table Inheritance (InheritanceType.SINGLE_TABLE)
Key Points:
One table for all entities: All entities in the inheritance hierarchy are stored in a single table.
Discriminator column: A column is added to indicate the type of entity (e.g., User, Children, Mentor, etc.).
All fields in the same table: Every field from the parent and subclasses will be in the same table. If a subclass doesn’t use a field from the parent, that field will still be NULL for the subclass rows.
Example of Single Table Inheritance
1. Parent Class (User)
java
Copy code
package com.TestProject.demo.Inheritances.SingleTable;

import jakarta.persistence.*;

@Entity(name = "user_singletable")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "user_type", discriminatorType = DiscriminatorType.STRING)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    // Constructors, Getters, Setters
}
@Inheritance(strategy = InheritanceType.SINGLE_TABLE): Specifies that all entities in the hierarchy will be stored in a single table.
@DiscriminatorColumn(name = "user_type", discriminatorType = DiscriminatorType.STRING): Defines a discriminator column (user_type) to distinguish between different entity types.
2. Subclass (Children)
java
Copy code
package com.TestProject.demo.Inheritances.SingleTable;

import jakarta.persistence.Entity;

@Entity(name = "children_singletable")
public class Children extends User {

    private String username;

    // Constructors, Getters, Setters
}
3. Another Subclass (Mentor)
java
Copy code
package com.TestProject.demo.Inheritances.SingleTable;

import jakarta.persistence.Entity;

@Entity(name = "mentor_singletable")
public class Mentor extends User {

    private String mentorName;

    // Constructors, Getters, Setters
}
Database Table Representation
With Single Table Inheritance, a single table is created for all the entities (User, Children, Mentor). This table will include columns for all fields from the parent and subclass entities, along with a discriminator column to distinguish between the different entity types.

Table: user_singletable
id	name	username	mentorName	user_type
1	Alice	NULL	NULL	Children
2	Bob	NULL	NULL	Children
3	Carol	NULL	Java Expert	Mentor
4	Dave	NULL	Python Expert	Mentor
The username and mentorName columns are NULL for rows where those fields are not applicable (i.e., for Mentor and Children rows).
The user_type column is the discriminator that tells Hibernate which subclass the row belongs to (Children, Mentor).
How It Works:
Single table: All entities in the inheritance hierarchy share the same table, and Hibernate automatically uses the user_type column to identify the type of entity.
Discriminator column: The user_type column is crucial because it allows Hibernate to determine which entity type the row represents. For example, user_type = 'Children' means that the row belongs to the Children entity.
Nullable fields: Any fields that are specific to a subclass (username for Children, mentorName for Mentor) will be NULL for the entities that don’t use them.
Polymorphic Query
You can query the User class and get instances of all subclasses (Children, Mentor, etc.) using a single query. For example:

java
Copy code
List<User> users = entityManager.createQuery("SELECT u FROM user_singletable u", User.class).getResultList();

for (User user : users) {
    if (user instanceof Children) {
        System.out.println("Children username: " + ((Children) user).getUsername());
    } else if (user instanceof Mentor) {
        System.out.println("Mentor name: " + ((Mentor) user).getMentorName());
    }
}
Advantages of Single Table Inheritance
Performance: Only one table is queried, which can improve performance in certain cases.
Simple schema: Easier to manage a single table instead of multiple tables for inheritance.
Less database joins: Since everything is in a single table, no joins are needed when querying related entities.
Disadvantages
Wasted space: Columns for non-applicable fields are NULL for some rows (e.g., username is NULL for Mentor).
Complex schema: If there are many subclasses with a lot of fields, the table can become very wide and difficult to manage.
Discriminator column: The use of a discriminator column may require extra care to ensure that it's properly maintained.
Conclusion
Single Table Inheritance is a good choice when:

You want a simpler schema with just one table for your entire inheritance hierarchy.
You don’t mind having many NULL values in the table for fields not relevant to certain subclasses.
You want to avoid the performance overhead of joins.
Would you like to explore more about other inheritance strategies, or do you have questions about this one?



     */
}
