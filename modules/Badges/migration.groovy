import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.grow.gamification.service.BadgeLocalServiceUtil;
import com.liferay.grow.gamification.service.LDateLocalServiceUtil;
import com.liferay.grow.gamification.model.Badge;
import java.util.List;
import java.util.UUID;

import com.liferay.portal.kernel.dao.jdbc.DataAccess;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

ResultSet rs = null;
Statement stmt = null;
Connection conn = null;

long companyId = 20099;
long groupId = 20142;
long thankyou = 1;
long respect = 4;

try {
	conn = DataAccess.getConnection();

	String query = "SELECT fromUser, createDate, modifiedDate, badgeType, assignDate, toUser, description, fromUserFullName FROM badgeportlet_badge ORDER BY badgeId;"

	stmt = conn.createStatement();
	rs = stmt.executeQuery(query);
	while (rs.next()) {

		long badgeId = CounterLocalServiceUtil.increment(Badge.class.getName());
		Badge badge = BadgeLocalServiceUtil.createBadge(badgeId);
		badge.setUserId(rs.getLong("fromUser"));

		Calendar cal = Calendar.getInstance();
		cal.setTime(rs.getTimestamp("assignDate"));

		long dateId = LDateLocalServiceUtil.getDateId(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH) + 1, cal.get(Calendar.DAY_OF_MONTH));

		badge.setAssignedDateId(dateId);
		badge.setBadgeTypeId((rs.getLong("badgeType") == 0) ? thankyou : respect);
		badge.setCompanyId(companyId);
		badge.setCreateDate(rs.getTimestamp("createDate"));
		badge.setDescription(rs.getString("description"));
		badge.setGroupId(groupId);
		badge.setToUserId(rs.getLong("toUser"));
		badge.setUserName(rs.getString("fromUserFullName"));
		badge.setUuid(UUID.randomUUID().toString());
		BadgeLocalServiceUtil.addBadge(badge);
	}
}
catch (Exception e) {
	out.println(e.getMessage());
}
finally {
	if (rs != null) {
		rs.close();
	}
	if (stmt != null) {
		stmt.close();
	}
	if (conn != null) {
		conn.close();
	}
}