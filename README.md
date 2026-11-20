# BaritoneElytraGuard

Fabric 客户端 mod：当 Baritone 正在执行普通（非鞘翅）寻路时，抑制 Tweakeroo 的 **Auto Switch Elytra**（`tweakAutoSwitchElytra`），避免空中按下跳跃键时自动换上鞘翅、意外触发滑翔而打断寻路。

## 行为

- Baritone 的普通寻路进行中时，拦截 Tweakeroo 对 `InventoryUtils#equipBestElytra` 的调用。
- 使用鞘翅寻路（`elytra` 命令）时完全不受影响。
- 不修改 Tweakeroo 的任何配置项；寻路结束或取消后自动恢复原行为。
- 只拦截“装备鞘翅”这一步，Tweakeroo 原有的落地换回胸甲逻辑不受影响。

## 依赖

| 依赖 | 版本 |
| --- | --- |
| Minecraft | 26.3 |
| Fabric Loader | >= 0.20.1 |
| Fabric Language Kotlin | 与 26.3 兼容的版本 |
| Baritone | 1.20.0（Fabric，MC 26.3） |
| Tweakeroo | 26.3-0.30.x |

## 工作方式

- 客户端 mixin 注入 Tweakeroo 的 `fi.dy.masa.tweakeroo.util.InventoryUtils#equipBestElytra`（`HEAD`，可取消）。
- 判定逻辑直接调用 Baritone 公共 API：
  - `IBaritone#getElytraProcess().isActive()` 为 `true`（鞘翅寻路）时不干预；
  - `IPathingBehavior#getGoal()` 非空表示 Baritone 的普通寻路进程仍持有寻路目标，覆盖寻路计算、暂停与执行阶段。
- 编译期依赖 `libs/` 中的 `baritone-api-fabric` jar，运行时由已安装的 Baritone 提供相同 API。

## 构建

```bash
./gradlew build
```

产物位于 `build/libs/`。

## 许可证

GPL-3.0-or-later，见 [LICENSE](LICENSE)。
