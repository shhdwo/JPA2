package com.capgemini.chess.service.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.capgemini.chess.dataaccess.entities.ProfileEntity;
import com.capgemini.chess.service.to.ProfileTO;

@Service
public class ProfileMapper implements Mapper<ProfileEntity, ProfileTO>{

	public ProfileTO map2To(ProfileEntity entity) {
		if (entity != null) {
			ProfileTO to = new ProfileTO();
			to.setId(entity.getId());
			to.setName(entity.getName());
			to.setSurname(entity.getSurname());
			to.setAboutMe(entity.getAboutMe());
			to.setLifeMotto(entity.getLifeMotto());
			return to;
		}
		return null;
	}

	public ProfileEntity map2Entity(ProfileTO to) {
		if (to != null) {
			ProfileEntity entity = new ProfileEntity();
			entity.setId(to.getId());
			entity.setName(to.getName());
			entity.setSurname(to.getSurname());
			entity.setAboutMe(to.getAboutMe());
			entity.setLifeMotto(to.getLifeMotto());
			return entity;
		}
		return null;
	}

	public List<ProfileTO> map2TOs(List<ProfileEntity> entities) {
		List<ProfileTO> tos = new ArrayList<ProfileTO>();
		for (ProfileEntity u : entities) {
			tos.add(map2To(u));
		}
		return tos;
	}

	public List<ProfileEntity> map2Entities(List<ProfileTO> tos) {
		List<ProfileEntity> entities = new ArrayList<ProfileEntity>();
		for (ProfileTO u : tos) {
			entities.add(map2Entity(u));
		}
		return entities;
	}
}
