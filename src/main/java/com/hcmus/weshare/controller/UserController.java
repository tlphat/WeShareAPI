package com.hcmus.weshare.controller;

import com.hcmus.weshare.dto.Connection;
import com.hcmus.weshare.model.Channel;
import com.hcmus.weshare.model.User;
import com.hcmus.weshare.repository.ChannelRepository;
import com.hcmus.weshare.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ChannelRepository channelRepository;

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable(value = "id") String userID) {
        Optional<User> user = userRepository.findById(userID);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("name/{displayName}")
    public ResponseEntity<List<User>> getUserByDisplayName(@PathVariable(value = "displayName") String displayName) {
        List<User> user = userRepository.findByDisplayName(displayName);
        return ResponseEntity.ok().body(user);
    }

    @GetMapping("/{id}/friends")
    public ResponseEntity<List<Connection>> getFriendsById(@PathVariable(value = "id") String userID) {
        List<Channel> ownerIds = channelRepository.findByOwnerId(userID);
        List<Channel> personIds = channelRepository.findByPersonId(userID);
        List<Connection> response = generateConnectionResponse(ownerIds, userID);
        response.addAll(generateConnectionResponse(personIds, userID));
        return ResponseEntity.ok().body(response);
    }

    private List<Connection> generateConnectionResponse(List<Channel> channelList, String userID) {
        List<Connection> response = new ArrayList<>();
        for (Channel channel : channelList) {
            response.add(new Connection(userRepository, channel, userID));
        }
        return response;
    }

}
