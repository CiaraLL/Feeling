package com.li.feeling.feellist.service;

import com.li.feeling.model.Feel;

import java.io.Serializable;
import java.util.List;

public class FeelListApiResponse<Feel> implements Serializable {
    List<Feel> mFeelList;
    String mFootTip;
}
