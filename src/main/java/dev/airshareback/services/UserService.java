package dev.airshareback.services;

import dev.airshareback.controllers.dto.UserDto;
import dev.airshareback.entities.ModerationStatus;
import dev.airshareback.entities.Role;
import dev.airshareback.entities.Status;
import dev.airshareback.entities.User;
import dev.airshareback.repositories.UserRepository;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;
    private RoleService roleService;
    private StatusService statusService;
    private ModerationStatusService mss;

    public UserService(UserRepository userRepository, RoleService roleService, StatusService statusService, ModerationStatusService mss) {
        this.userRepository = userRepository;
        this.roleService = roleService;
        this.statusService = statusService;
        this.mss = mss;
    }

    public User create(@Valid UserDto u) {
        StringBuilder sb = new StringBuilder();

        Optional<Role> role = roleService.findByName(u.getRole());
        Optional<Status> status = statusService.findByName(u.getStatus());
        Optional<ModerationStatus> moderationStatus = mss.findByName(u.getModerationStatus());

        if (role.isEmpty())
            sb.append("Role inexistant!");

        if (status.isEmpty())
            sb.append("Statut inexistant!");

        if (moderationStatus.isEmpty())
            sb.append("Statut de modération inexistant!");

        User user = new User();
        user.setPseudo(u.getPseudo());
        user.setFirstName(u.getFirstName());
        user.setLastName(u.getLastName());
        user.setMailAddress(u.getMailAddress());
        // TODO: Hash
        user.setPassword(u.getPassword());
        user.setStatus(status.get());
        user.setRole(role.get());
        user.setModerationStatus(moderationStatus.get());

        return userRepository.save(user);
    }

    public List<User> list() {
        return userRepository.findAll();
    }

    public Optional<User> findByFirst_name(String pseudo) {
        return userRepository.findByPseudo(pseudo);
    }

    public Optional<User> get(Long id) {
        return userRepository.findById(id);
    }


}
