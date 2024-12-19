package in.ashokit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ashokit.entities.AppEntity;

public interface AppRepo extends JpaRepository<AppEntity, Long> {

}
