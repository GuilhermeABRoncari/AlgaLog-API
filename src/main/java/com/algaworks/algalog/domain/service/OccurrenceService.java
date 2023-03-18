package com.algaworks.algalog.domain.service;

import com.algaworks.algalog.domain.entity.Occurrence;
import com.algaworks.algalog.domain.exception.NotFoundIdException;
import com.algaworks.algalog.domain.reposiotry.DeliveryRepository;
import com.algaworks.algalog.domain.reposiotry.OccurrenceRepository;
import com.algaworks.algalog.domain.response.OccurrenceResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class OccurrenceService {
    private DeliveryRepository deliveryRepository;
    private OccurrenceRepository occurrenceRepository;

    @Transactional
    public OccurrenceResponse register(Long id, String description) {
        var delivery = deliveryRepository.findById(id).orElseThrow(() -> new NotFoundIdException("Delivery not found."));
        var response = delivery.addOccurrence(description);
        occurrenceRepository.save(response);
        return  new OccurrenceResponse(response);
    }
    public List<OccurrenceResponse> list(Long id) {
        var delivery = deliveryRepository.findById(id).orElseThrow(() -> new NotFoundIdException("Delivery not found."));
        var list = delivery.getOccurrenceList();
        return list.stream().map(occurrence -> new OccurrenceResponse(occurrence)).collect(Collectors.toList());
    }
}
