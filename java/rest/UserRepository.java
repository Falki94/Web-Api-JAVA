/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import domain.User;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
/**
 *
 * @author Maciek
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long>{
    
}
