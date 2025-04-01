package com.TestProject.demo.Inheritances.JoinedTable;

public class Explanation {
   /* @Component
    public class DataLoader {

        @Bean
        CommandLineRunner initData(EmployeeRepository employeeRepository) {
            return args -> {
                Manager manager = new Manager();
                manager.setName("Alice");
                manager.setSalary(90000);
                manager.setDepartment("HR");

                Developer developer = new Developer();
                developer.setName("Bob");
                developer.setSalary(80000);
                developer.setProgrammingLanguage("Java");

                employeeRepository.save(manager);
                employeeRepository.save(developer);
            };
        }

        we wont insert in the Employee main table which is having primary key if manager and Developer any thing
        added will be added to Employee

      How the Data is Stored in the Database
Employee Table
| id | name | salary | dtype |
|----|--------|--------|-------------|
| 1 | Alice | 90000 | Manager |
| 2 | Bob | 80000 | Developer |

Manager Table
| id | department |
|----|------------|
| 1 | HR |

Developer Table
| id | programming_language |
|----|-----------------------|
| 2 | Java |

        */
}
