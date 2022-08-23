package dev.airshareback.services;

import dev.airshareback.entities.ModerationStatus;
import dev.airshareback.entities.Status;
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

    public ModerationStatus create(String name) {
        ModerationStatus s = new ModerationStatus();
        s.setName(name);
        return msr.save(s);
    }
}
