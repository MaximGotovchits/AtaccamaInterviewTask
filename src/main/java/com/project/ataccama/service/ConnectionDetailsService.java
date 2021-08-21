package com.project.ataccama.service;

import java.util.List;

public interface ConnectionDetailsService {
    void save();
    void update();
    List<String> list();
    void delete();
}
