package lab.hoangnv.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface IService {

    ResponseEntity<Object> select();
}
