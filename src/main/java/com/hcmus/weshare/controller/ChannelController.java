package com.hcmus.weshare.controller;

import com.hcmus.weshare.model.Channel;
import com.hcmus.weshare.model.User;
import com.hcmus.weshare.repository.ChannelRepository;
import com.hcmus.weshare.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/channels")
public class ChannelController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ChannelRepository channelRepository;

    @PostMapping
    public ResponseEntity<Channel> createChannel(@RequestBody Channel channel) {
        Optional<User> owner = userRepository.findById(channel.getOwnerId());
        Optional<User> person = userRepository.findById(channel.getPersonId());
        if (owner.isPresent() && person.isPresent()) {
            return ResponseEntity.ok(channelRepository.save(channel));
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }

}
