package com.testproject.data.repository;

import java.util.ArrayList;
import java.util.List;



import com.testproject.data.entities.User;

public class UserRepo {
    private List <User> users = new ArrayList<>();

    
    public UserRepo(){
        users.add(new User(1, "fadlid", "yandrbva", 23,"fad@gmail.com", "122"));
        users.add(new User(2, "fadlids", "yandsrasf", 23,"fad@gmail.com","123"));
        users.add(new User(3, "fadlissf", "yanvsdra", 23,"fad@gmail.com","123"));
        users.add(new User(4, "fadlisf", "yandvsra", 23,"fad@gmail.com","12"));

    }
        public List<User> getUsers(){
            return users;
        }

        public User findUserById(long id) { 
            for (User user : users) {
                if (user.getId() == id) {
                    return user;
                }
            }
            return null;
        } 
        public void removeUserById(int id){
            users.removeIf(pc -> pc.getId() == id);
        //    for(Person person : persons){
        //     if (person.getId() == id) {
        //         persons.remove(person);
        //         break;
        //     }
        //    }
        }

        public void addUser(User user){
            long nextId = users.size() + 1;
            user.setId(nextId);
            users.add(user);
        }

        public void updateUser(User user){
            for(User u : users){
                if (u.getId() == user.getId()) {
                    u.setFirstName(user.getFirstName());
                    u.setLastName(user.getLastName());
                    u.setAge(user.getAge());
                    u.setEmail(user.getEmail());
                    break;
                    
                }
            }
        }


    
        
    }

