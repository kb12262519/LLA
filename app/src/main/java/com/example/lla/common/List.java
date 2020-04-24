package com.example.lla.common;

public class List {
    /*메인 액티비티에 올라 갈 수 있는 Fragment 목록*/
    public enum Fragment {Main, Random, Select, Option, Game}

    /*게임 목록*/
    public enum Game {LiarGame, UpAndDown}

    /*게임을 표시할 프레그먼트의 종류*/
    public enum gameFragment {LiarGame, UpAndDown ,Else}
}
