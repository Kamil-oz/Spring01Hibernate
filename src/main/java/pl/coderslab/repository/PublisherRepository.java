package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.coderslab.model.Publisher;

public interface PublisherRepository extends JpaRepository<Publisher, Long>{
	Publisher findFirstPublisherByNip(String nip);
}
