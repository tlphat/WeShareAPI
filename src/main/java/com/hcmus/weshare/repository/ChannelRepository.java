package com.hcmus.weshare.repository;

import com.hcmus.weshare.model.Channel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChannelRepository extends JpaRepository<Channel, String> {
    List<Channel> findByOwnerId(String id);
    List<Channel> findByPersonId(String id);
}
