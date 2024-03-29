package com.example.android.navigation;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.navigation.NavArgs;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class PlayerOneWonFragmentArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private PlayerOneWonFragmentArgs() {
  }

  private PlayerOneWonFragmentArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static PlayerOneWonFragmentArgs fromBundle(@NonNull Bundle bundle) {
    PlayerOneWonFragmentArgs __result = new PlayerOneWonFragmentArgs();
    bundle.setClassLoader(PlayerOneWonFragmentArgs.class.getClassLoader());
    if (bundle.containsKey("score")) {
      int score;
      score = bundle.getInt("score");
      __result.arguments.put("score", score);
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  public int getScore() {
    return (int) arguments.get("score");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public Bundle toBundle() {
    Bundle __result = new Bundle();
    if (arguments.containsKey("score")) {
      int score = (int) arguments.get("score");
      __result.putInt("score", score);
    }
    return __result;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
        return true;
    }
    if (object == null || getClass() != object.getClass()) {
        return false;
    }
    PlayerOneWonFragmentArgs that = (PlayerOneWonFragmentArgs) object;
    if (arguments.containsKey("score") != that.arguments.containsKey("score")) {
      return false;
    }
    if (getScore() != that.getScore()) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + getScore();
    return result;
  }

  @Override
  public String toString() {
    return "PlayerOneWonFragmentArgs{"
        + "score=" + getScore()
        + "}";
  }

  public static class Builder {
    private final HashMap arguments = new HashMap();

    public Builder(PlayerOneWonFragmentArgs original) {
      this.arguments.putAll(original.arguments);
    }

    public Builder() {
    }

    @NonNull
    public PlayerOneWonFragmentArgs build() {
      PlayerOneWonFragmentArgs result = new PlayerOneWonFragmentArgs(arguments);
      return result;
    }

    @NonNull
    public Builder setScore(int score) {
      this.arguments.put("score", score);
      return this;
    }

    @SuppressWarnings("unchecked")
    public int getScore() {
      return (int) arguments.get("score");
    }
  }
}
