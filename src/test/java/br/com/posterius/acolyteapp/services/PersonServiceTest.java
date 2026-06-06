package br.com.posterius.acolyteapp.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.posterius.acolyteapp.controller.person.PersonDTO;
import br.com.posterius.acolyteapp.repositories.person.PersonRepository;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {
    @InjectMocks
    private PersonService personService;

    @Mock
    private PersonRepository personRespository;

    @Test
    @DisplayName("Should throw an exception when person is a minor.")
    public void shouldThrowExceptionWhenPersonIsMinor() {
       PersonDTO personDTO = new PersonDTO(null, 1, "Alphonsus","Mary of Ligouri", DataTestsHelper.stringToTimestamp("2010-01-01 00:00:00"), false);
       Assertions.assertThrows(IllegalArgumentException.class, () -> personService.save(personDTO));
    }
}
