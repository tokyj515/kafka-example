package com.kt;

import com.kt.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
