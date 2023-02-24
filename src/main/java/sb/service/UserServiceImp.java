package sb.service;

import sb.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sb.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImp implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> index() {
        return userRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public User read(int id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElse(null);
    }

    @Override
    public void create(User user) {
        userRepository.save(user);
    }

    @Override
    public void update(int id, User user) {
        user.setId(id);
        userRepository.save(user);
    }

    @Override
    public void delete(int id) {
        userRepository.deleteById(id);
    }
}
