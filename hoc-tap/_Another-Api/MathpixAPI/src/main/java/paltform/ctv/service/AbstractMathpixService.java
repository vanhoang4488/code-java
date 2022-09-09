package paltform.ctv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import paltform.ctv.dao.repository.impl.ImageRepository;

@Service
public abstract class AbstractMathpixService {

    @Autowired
    protected ImageRepository imageRepository;
}
