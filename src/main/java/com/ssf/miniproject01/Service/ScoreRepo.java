package com.ssf.miniproject01.Service;

import com.ssf.miniproject01.Model.Data;

public interface ScoreRepo {
    public int save(final Data user);

    public int update(final Data user);
}
