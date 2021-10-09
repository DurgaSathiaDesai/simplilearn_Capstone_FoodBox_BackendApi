package com.simplilearn.capstone.foodboxWebApplication.Service;

import com.simplilearn.capstone.foodboxWebApplication.Dto.Userdetails;
import com.simplilearn.capstone.foodboxWebApplication.Entity.userInfo;

public interface userService 
{
    userInfo registerUser(Userdetails userdet);
}
