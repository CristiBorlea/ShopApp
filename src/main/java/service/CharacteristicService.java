package service;

import dao.CharacteristicDao;
import dto.CharacteristicDto;
import model.Characteristic;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Service handling business logic of characteristic entities.
 *
 * @author Cristi Borlea
 * @version 1.0
 */

public class CharacteristicService {

    private CharacteristicDao characteristicDao;

    public CharacteristicService() {
        this.characteristicDao = new CharacteristicDao();
    }

    /**
     * This method return a list of characteristicDto
     *
     * @return characteristicDtos list
     * @throws SQLException
     */
    public List<CharacteristicDto> getCharacteristicForProduct(int productId) throws SQLException {
        List<CharacteristicDto> characteristicDtoList = new ArrayList<>();
        List<Characteristic> characteristics = characteristicDao.getCharacteristicForProduct(productId);
        for (Characteristic c : characteristics) {
            CharacteristicDto characteristicDTO = convert(c);
            characteristicDtoList.add(characteristicDTO);
        }
        return characteristicDtoList;
    }

    /**
     * This method convert Characteristic model to CharacteristicDto
     */
    private CharacteristicDto convert(Characteristic characteristic) {
        CharacteristicDto dto = new CharacteristicDto();
        dto.setName(characteristic.getName());
        dto.setValue(characteristic.getValue());
        return dto;
    }
}
