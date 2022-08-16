package dev.airshareback.services;

import dev.airshareback.entities.ModerationStatus;
import dev.airshareback.repositories.ModerationStatusRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModerationStatusService {
    private ModerationStatusRepository msr;

    public ModerationStatusService(ModerationStatusRepository msr) {
        this.msr = msr;
    }

    public List<ModerationStatus> list() {
        return msr.findAll();
    }

    public Optional<ModerationStatus> get(int id) {
        return msr.findById(id);
    }

    public Optional<ModerationStatus> findByName(String name) {
        return msr.findByName(name);
    }
}
