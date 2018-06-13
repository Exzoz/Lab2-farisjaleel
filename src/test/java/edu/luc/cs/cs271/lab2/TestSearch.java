package edu.luc.cs.cs271.lab2;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestSearch {

  Team[] makeArrayFixture(final int size) {
    final Team[] array = new Team[size];
    for (int i = 0; i < size; i++) {
      final String s = Integer.toString(i);
      array[i] = new Team("Team " + s, "Coach " + s, i * 100 + 50);
    }
    return array;
  }

  List<Team> makeListFixture(final int size) {
    final List<Team> list = new ArrayList<Team>();
    for (int i = 0; i < size; i++) {
      final String s = Integer.toString(i);
      list.add(new Team("Team " + s, "Coach" + s, i * 100 + 50));
    }
    return list;
  }

  @Test
  public void testFindPositionArray0() {
    final Team[] arr = makeArrayFixture(0);
    assertFalse(Search.findTeamPosition(arr, "Team 5").isPresent());
  }

  @Test
  public void testFindPositionArray10s() {
    final Team[] arr = makeArrayFixture(10);
    assertTrue(Search.findTeamPosition(arr, "Team 5").isPresent());
  }

  @Test
  public void testFindPositionArray10f() {
    final Team[] arr = makeArrayFixture(10);
    assertFalse(Search.findTeamPosition(arr, "Team 11").isPresent());
  }

  @Test
  public void testFindPositionList0() {
    final List<Team> list = makeListFixture(0);
    assertFalse(Search.findTeamPosition(list, "Team 5").isPresent());
  }

  @Test
  public void testFindPositionList10() {
    final List<Team> list = makeListFixture(10);
    Optional<Integer> team = Search.findTeamPosition(list, "Team 5");
    assertTrue(team.isPresent());
    assertTrue(team.get() == 5);
  }

  @Test
  public void testFindPositionList() {
    final List<Team> list = makeListFixture(10);
    Optional<Integer> team = Search.findTeamPosition(list, "Team 7");
    assertTrue(team.isPresent());
    assertTrue(team.get() == 7);
  }

  @Test
  public void testFindPositionList11() {
    final List<Team> list = makeListFixture(10);
    Optional<Integer> team = Search.findTeamPosition(list, "Team 11");
    assertFalse(team.isPresent());
  }

  //Below are the tests for findTeamMinFunding

  @Test
  public void testFindMinFundingArrayMin0() {
    final Team[] arr = makeArrayFixture(0);
    Optional<Integer> team = Search.findTeamMinFunding(arr, 200);
    assertTrue(team.isPresent());
    assertTrue(team.get() == -1);
  }

  @Test
  public void testFindMinFundingArrayMin50() {
    final Team[] arr = makeArrayFixture(10);
    Optional<Integer> team = Search.findTeamMinFunding(arr, 50);
    assertTrue(team.isPresent());
    assertTrue(team.get() == 0);
  }

  @Test
  public void testFindMinFundingArrayMin200() {
    final Team[] arr = makeArrayFixture(10);
    Optional<Integer> team = Search.findTeamMinFunding(arr, 200);
    assertTrue(team.isPresent());
    assertTrue(team.get() == 2);
  }

  @Test
  public void testFindMinFundingArrayMin250() {
    final Team[] arr = makeArrayFixture(10);
    Optional<Integer> team = Search.findTeamMinFunding(arr, 250);
    assertTrue(team.isPresent());
    assertTrue(team.get() == 2);
  }

  @Test
  public void testFindMinFundingArrayMin300() {
    final Team[] arr = makeArrayFixture(10);
    Optional<Integer> team = Search.findTeamMinFunding(arr, 300);
    assertTrue(team.isPresent());
    assertTrue(team.get() == 3);
  }

  @Test
  public void testFindMinFundingArrayMin950() {
    final Team[] arr = makeArrayFixture(10);
    Optional<Integer> team = Search.findTeamMinFunding(arr, 950);
    assertTrue(team.isPresent());
    assertTrue(team.get() == 9);
  }

  @Test
  public void testFindMinFundingArrayMin1000() {
    final Team[] arr = makeArrayFixture(10);
    Optional<Integer> team = Search.findTeamMinFunding(arr, 1000);
    assertTrue(team.isPresent());
    assertTrue(team.get() == -1);
  }

 // Below are the tests for findMinFundingArrayFast


  @Test
  public void testFindMinFundingFastArrayMin0() {
    final Team[] arr = makeArrayFixture(0);
    Optional<Integer> team = Search.findTeamMinFundingFast(arr, 200);
    assertTrue(team.isPresent());
    assertTrue(team.get() == -1);
  }

  @Test
  public void testFindMinFundingFastArrayMin50() {
    final Team[] arr = makeArrayFixture(10);
    Optional<Integer> team = Search.findTeamMinFundingFast(arr, 50);
    assertTrue(team.isPresent());
    assertTrue(team.get() == 0);
  }

  @Test
  public void testFindMinFundingFastArrayMin200() {
    final Team[] arr = makeArrayFixture(10);
    Optional<Integer> team = Search.findTeamMinFundingFast(arr, 200);
    assertTrue(team.isPresent());
    assertTrue(team.get() == 2);
  }

  @Test
  public void testFindMinFundingFastArrayMin250() {
    final Team[] arr = makeArrayFixture(10);
    Optional<Integer> team = Search.findTeamMinFundingFast(arr, 250);
    assertTrue(team.isPresent());
    assertTrue(team.get() == 2);
  }

  @Test
  public void testFindMinFundingFastArrayMin300() {
    final Team[] arr = makeArrayFixture(10);
    Optional<Integer> team = Search.findTeamMinFundingFast(arr, 300);
    assertTrue(team.isPresent());
    assertTrue(team.get() == 3);
  }

  @Test
  public void testFindMinFundingFastArrayMin950() {
    final Team[] arr = makeArrayFixture(10);
    Optional<Integer> team = Search.findTeamMinFundingFast(arr, 950);
    assertTrue(team.isPresent());
    assertTrue(team.get() == 9);
  }

  @Test
  public void testFindMinFundingFastArrayMin1000() {
    final Team[] arr = makeArrayFixture(10);
    Optional<Integer> team = Search.findTeamMinFundingFast(arr, 1000);
    assertTrue(team.isPresent());
    assertTrue(team.get() == -1);
  }
}