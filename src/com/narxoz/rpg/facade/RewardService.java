package com.narxoz.rpg.facade;

public class RewardService {
    public String determineReward(AdventureResult battleResult) {
        if (battleResult.getWinner() == null || !battleResult.getWinner().equals("CyberKnight")) {
        return "No loot this time.";
    }
    return "Golden Artifact and 500 XP";
    }
}
