package lec.sunday00.reservation.service;

import lec.sunday00.reservation.model.Display;
import lec.sunday00.reservation.repository.DisplayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisplayService implements DisplayServiceInterface{

    @Autowired
    DisplayRepository displayRepository;

    @Override
    public int selectCount(String category) {
        return displayRepository.selectCount(category);
    }

    @Override
    public List<Display> select(String category, int page) {
        return displayRepository.select(category, page);
    }

    @Override
    public Display selectOne(int id) {
        return displayRepository.selectOne(id);
    }
}
