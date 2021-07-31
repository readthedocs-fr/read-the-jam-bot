package fr.lukam.jambot.commands;

import fr.lukam.jambot.model.Authorized;
import fr.lukam.jambot.model.RoleId;
import fr.lukam.jambot.utils.ConfigurationUtils;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public abstract class StaffCommand extends Command {

    private final RoleId roleID;
    private final Authorized authorized;

    public StaffCommand() {
        this.roleID = ConfigurationUtils.getRoleID();
        this.authorized = ConfigurationUtils.getAuthorized();
    }

    @Override
    public boolean canExecute(GuildMessageReceivedEvent event) {
        Role role = event.getGuild().getRoleById(roleID.id);

        if (role == null) {
            return false;
        }

        Member member = event.getMember();

        if (member == null) {
            return false;
        }

        return member.getRoles().stream().anyMatch(role2 -> role2.getIdLong() == role.getIdLong())
                || authorized.isAuthorized(member.getIdLong());
    }

}
