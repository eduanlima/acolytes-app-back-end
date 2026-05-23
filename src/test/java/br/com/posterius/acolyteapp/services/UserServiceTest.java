package br.com.posterius.acolyteapp.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

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
        userService.findAll();
    }
}