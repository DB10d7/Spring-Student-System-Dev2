package com.packetprep.system.repository;

import com.packetprep.system.Model.Batch;
import com.packetprep.system.Model.Day;
import com.packetprep.system.Model.Image;
import com.packetprep.system.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    List<User> findAll();

    Optional<User> findById(Long id);

    Optional<Image> findByImage(Image image);

    List<User> findAllByDay(Day day);

    List<User> findAllByBatch(Batch batch);

    @Override
    void deleteById(Long id);
}

