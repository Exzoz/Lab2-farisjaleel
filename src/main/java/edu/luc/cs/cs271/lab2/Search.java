package edu.luc.cs.cs271.lab2;

import java.util.List;
import java.util.Optional;

public class Search {

  /** Looks for the position of the named team in an array. */
  public static Optional<Integer> findTeamPosition(final Team[] arr, final String key) {
    // Gets the array size
    final int size = arr.length;
    // Runs through a for loop to check
    for (int i = 0; i < size; i++) {
      // Gets the current item at index and compare name to key
      if (arr[i].getName().equals(key)) {
        // Return the index of where the item with key is located
        return Optional.of(i);
      }
    }
    // If it does not exist in the array then return an index of -1
    return Optional.empty();
  }

  /** Looks for the position of the named team in a list. */
  public static Optional<Integer> findTeamPosition(final List<Team> list, final String key) {
    //Obtains list size
    final int size = list.size();
    //for loop to check
    for (int i = 0; i < size; i++) {
      // Uses current item at index and compares the name to key
      if (list.get(i).getName().equals(key)) {
        return Optional.of(i);
      }
    }
    // If nonexistent in array then returns index of -1
    return Optional.empty();
  }
  
  /** 
   * Looks for the position of the poorest team that has at least 
   * the specified funding level.
   * @pre arr is sorted
   * @post arr[result].funding >= minFunding && for all 0 <= i < result : arr[i].funding < minFunding
   */
  public static Optional<Integer> findTeamMinFunding(final Team[] arr, final int minFunding) {
    // Gets array size
    final int size = arr.length;
    Team currentTeam = null;
    int currentTeamPosition = -1;

    //for loop to check
    for (int i = 0; i < size; i++){
      //Checks to see if team funding is more or equal to minFunding
      if (arr[i].getFunding() >= minFunding) {
        if (currentTeam == null || currentTeam.getFunding() > arr[i].getFunding()) {
          currentTeam = arr[i];
          currentTeamPosition = i;
        }
      }
    }
    return Optional.of(currentTeamPosition);
  }
  
  /** 
   * Looks for the position of the poorest team that has at least 
   * the specified funding level. 
   * Uses binary search: Initially consider the entire index range, 
   * then repeatedly eliminate the wrong half of the array until 
   * zero or one items are left.
   * @pre arr is sorted
   * @post arr[result].funding >= minFunding && for all 0 <= i < result : arr[i].funding < minFunding
   */
  public static Optional<Integer> findTeamMinFundingFast(final Team[] arr, final int minFunding) {
    // Gets the array size
    final int size = arr.length;
    if (size == 0) {
      return Optional.of(-1);
    }
    // Initially consider the entire index range of the array
    int low = 0;
    int high = size - 1;
    // Keep going as long as there is more than one item to be checked
    // Eliminate the wrong half of the array
    // Return current item only if it meets the condition!
    while (low <= high) {
      int mid = (low + high) / 2;
      if (arr[mid].getFunding() < minFunding) {
        low = mid + 1;
      } else if (arr[mid].getFunding() > minFunding) {
        high = mid -1;
      } else if (arr[mid].getFunding() == minFunding) {
          return Optional.of(mid);
      }
    }
    if (low >= size) {
      return Optional.of(-1);
    } else {
      return Optional.of(low);
    }
  }
}
