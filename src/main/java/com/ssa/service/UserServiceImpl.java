package com.ssa.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssa.bo.UserRequest;
import com.ssa.bo.UserResponse;
import com.ssa.entity.UserEntity;
import com.ssa.exception.NoDataFoundException;
import com.ssa.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepo;

	@Override
	public Long ssnEnrollment(UserRequest user) {

		UserEntity entity = new UserEntity();

		BeanUtils.copyProperties(user, entity);

		UserEntity savedEntity = userRepo.save(entity);

		return savedEntity.getSsnNo();
	}

	@Override
	public UserResponse getUserDataBySSN(Long ssnNo) {

		Optional<UserEntity> findById = userRepo.findById(ssnNo);

		if (findById.isPresent()) {
			UserEntity userEntity = findById.get();
			UserResponse response = new UserResponse();

			BeanUtils.copyProperties(userEntity, response);

			return response;
		} else {
			throw new NoDataFoundException("no data found");
		}

	}

}
