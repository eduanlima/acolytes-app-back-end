package br.com.posterius.acolyteapp.services;

import java.security.Timestamp;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.posterius.acolyteapp.controller.user.UserDTO;
import br.com.posterius.acolyteapp.entities.person.PersonEntity;
import br.com.posterius.acolyteapp.repositories.acolyte.AcolyteRepository;
import br.com.posterius.acolyteapp.repositories.position.PositionRepository;
import br.com.posterius.acolyteapp.repositories.user.UserRepository;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @InjectMocks
    private UserService userService;

    @Mock
	private UserRepository userRepository;
	
	@Mock
	private PositionRepository positionRepository;
	
	@Mock
	private AcolyteRepository acolyteRepository;

    @Test
    public void shouldReturnAllUsersWhenUserExits() {
        //PersonEntity personEntity = new PersonEntity("50f0c341-ceb5-4aa9-971f-fb14337abd0c", 1,"Alphonsus","Mary of Ligouri", "1990-01-01 00:00:00", false);

        List<UserDTO> users = userService.findAll();
        System.out.println("Users: " + users);
    }
}