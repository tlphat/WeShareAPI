package com.hcmus.weshare.dto;

import com.hcmus.weshare.model.Channel;
import com.hcmus.weshare.model.User;
import com.hcmus.weshare.repository.UserRepository;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Connection {

    private String connectionID;
    private User user;

    public Connection(UserRepository userRepository, Channel channel, String userID) {
        connectionID = String.valueOf(channel.getId());
        if (channel.getOwnerId().equals(userID)) {
            user = userRepository.findById(channel.getPersonId()).orElse(null);
        } else {
            user = userRepository.findById(channel.getOwnerId()).orElse(null);
        }
    }

}
