package com.springcapstone.speaker.repositories;

import com.springcapstone.speaker.models.Speaker;
import org.springframework.data.jpa.repository.*;

public interface SpeakerRepository extends JpaRepository <Speaker, Long> {

}
