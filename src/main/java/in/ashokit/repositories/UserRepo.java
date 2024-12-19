package in.ashokit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ashokit.entities.UserEntity;

public interface UserRepo extends JpaRepository<UserEntity, Integer>{

}
