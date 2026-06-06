package br.com.posterius.acolyteapp.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.posterius.acolyteapp.controller.user.UserDTO;
import br.com.posterius.acolyteapp.entities.person.PersonEntity;
import br.com.posterius.acolyteapp.entities.user.UserEntity;
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
    @DisplayName("Should return a list of user with only one register.")
    public void shouldReturnAllUsersWhenUserExits() {
        PersonEntity personEntity = new PersonEntity(UUID.fromString("50f0c341-ceb5-4aa9-971f-fb14337abd0c"), 1,"Alphonsus","Mary of Ligouri", DataTestsHelper.stringToTimestamp("1990-01-01 00:00:00"), false);
        UserEntity userEntity = new UserEntity(UUID.fromString("50f0c341-ceb5-4aa9-971f-fb14337abd0c"), "test@test.com", "12345678", false, null, personEntity, new ArrayList<>());
        
        Mockito.when(userRepository.findAll()).thenReturn(Collections.singletonList(userEntity));
        
        List<UserDTO> users = userService.findAll();

        Assertions.assertEquals(1, users.size());
    }
}