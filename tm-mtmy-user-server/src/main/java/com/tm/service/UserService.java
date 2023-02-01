package com.tm.service;

import com.tm.entity.QRCodeUserLogin;
import com.tm.entity.User;
import com.tm.entity.UserByFlag;
import com.tm.entity.dto.UserDTO;
import com.tm.result.Result;
import com.tm.result.ResultCodeEnum;

public interface UserService {

    Result userRegister(UserDTO user);

    Result userLogin(UserDTO user);

    Result saveLoginFlag(UserByFlag userByFlag);

    Result queryUserByFlag(UserByFlag userByFlag);

    Result userQRCodeLogin(QRCodeUserLogin qrCodeUserLogin);
}
