package com.capgemini.chess.service.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.capgemini.chess.dataaccess.entities.ProfileEntity;
import com.capgemini.chess.service.to.ProfileTO;

public class ProfileMapper {

	public static ProfileTO map(ProfileEntity entity) {
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

	public static ProfileEntity map(ProfileTO to) {
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

	public static List<ProfileTO> map2TOs(List<ProfileEntity> entities) {
		return entities.stream().map(ProfileMapper::map).collect(Collectors.toList());
	}

	public static List<ProfileEntity> map2Entities(List<ProfileTO> tos) {
		return tos.stream().map(ProfileMapper::map).collect(Collectors.toList());
	}
}
