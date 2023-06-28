package br.com.cisbrasil.found.service;

import br.com.cisbrasil.found.exceptions.InvalidEntryException;
import br.com.cisbrasil.found.exceptions.NotFoundException;
import br.com.cisbrasil.found.model.Cost;
import br.com.cisbrasil.found.repository.CostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CostService {
    @Autowired
    CostRepository repository;
    public List<Cost> findAll() {
        return repository.findAllCosts();
    }

    public Cost get(int id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Cost not found"));
    }
    public Cost save(Cost cost) {
        return repository.save(cost);
    }

    public void delete(int id) {
        Cost cost = repository.findById(id).orElseThrow(() -> new NotFoundException("Cost not found"));
        repository.delete(cost);
    }

    public Cost update(Cost costToUpdate, int costId) {
        Cost oldCost = this.get(costId);
        if (costToUpdate.getId() != (costId)) {
            throw new InvalidEntryException("The id from the body can't be different from the id from the request");
        }

        return repository.save(mergeNotNullParamsForUpdate(oldCost, costToUpdate));
    }

    private Cost mergeNotNullParamsForUpdate(Cost oldCost, Cost newCost) {
        if (newCost.getValue() == 0.0) {
            newCost.setValue(oldCost.getValue());
        }

        if (newCost.getDueDate() == null) {
            newCost.setDueDate(oldCost.getDueDate());
        }

        if (newCost.getDescription() == null) {
            newCost.setDescription(oldCost.getDescription());
        }

        if (newCost.getApproval() == null) {
            newCost.setApproval(oldCost.getApproval());
        }

        if (newCost.getSendDate() == null) {
            newCost.setSendDate(oldCost.getSendDate());
        }

        if (newCost.getInvoiceNumber() == 0) {
            newCost.setInvoiceNumber(oldCost.getInvoiceNumber());
        }

        return newCost;
    }
}
