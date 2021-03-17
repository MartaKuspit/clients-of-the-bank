package my.project.client;

import my.project.address.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ClientRepository extends JpaRepository<Client,Long> {


    @Query("SELECT c FROM Client c WHERE c.firstName = :firstName AND c.lastName = :lastName")
    Client findByName(@Param("firstName") String firstName, @Param("lastName") String lastName);

    @Query("SELECT c FROM Client c WHERE c.pesel = :pesel")
    Client findByPesel(@Param("pesel") String pesel);

    @Query("SELECT a FROM Address a INNER JOIN Client WHERE a.id = :id")
    Address findAddress(@Param("id") Long id);
}

