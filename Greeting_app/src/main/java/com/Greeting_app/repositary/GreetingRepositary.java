package com.Greeting_app.repositary;

import com.Greeting_app.Entity.GreetingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GreetingRepositary extends JpaRepository<GreetingEntity,Long> {
}
