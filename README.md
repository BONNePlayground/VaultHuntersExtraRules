<a href="https://www.curseforge.com/minecraft/mc-mods/vault-hunters-extra-game-rules"><img src="http://cf.way2muchnoise.eu/917565.svg" alt="CF"></a>

# Vault Hunters Extra Rules

This simple mod adds some new Game Rules to allow more adjustments to the Vault Looting.
This mod works extremely well with "Arcade Mode".

## Game Rules
- vaultExtraCopiouslyDropModifier (default: NORMAL) - the increase of drops from copiously triggering. 
  - LEGACY: 0.5x - reduces the drop in half
  - NORMAL: 1.0x (default) - no change
  - PLENTY: 2.0x - double the drop from copiously
  - EXTREME: 3.0x - triples the drop from copiously
- vaultExtraCoinDrops (default: NORMAL) - the chance of increased coin drops from mining in the vault
  - LEGACY: 0.5x - reduces the drop in half
  - NORMAL: 0.0x (default) - no change
  - PLENTY: 1.0x - increases the coin quantity by 1
  - EXTREME: 2.0x - increases the coin quantity by 2
- vaultExtraCompletionExperienceModifier (default: NORMAL) - the experience for completing the vault
  - NONE: 0.0x - no experience for completing the vault
  - TURTLE: 0.33x - 1/3 of the experience for completing the vault
  - SLOW: 0.5x - 1/2 of the experience for completing the vault
  - NORMAL: 1.0x (default) - no change
  - PLENTY: 2.0x - 2x the experience for completing the vault
  - EXTREME: 3.0x - 3x the experience for completing the vault
- vaultExtraBonusExperienceModifier (default: NORMAL) - the bonus experience from the vault
  - NONE: 0.0x - no bonus experience from the vault
  - TURTLE: 0.33x - 1/3 of the bonus experience from the vault
  - SLOW: 0.5x - 1/2 of the bonus experience from the vault
  - NORMAL: 1.0x (default) - no change
  - PLENTY: 2.0x - 2x the bonus experience from the vault
  - EXTREME: 3.0x - 3x the bonus experience from the vault
- vaultExtraReusePedestals (default: false) - whether to allow reusing crake pedestals and lodestones in the vault
  - true - allows reusing crake pedestals and lodestones in the vault
  - false (default) - no change
- vaultExtraLocalizedGameRules (default: false) - whether to allow localized game rules in the vault
  - true - allows localized game rules in the vault
  - false (default) - no change
- vaultExtraAllowFlasksWhilePause (default: false) - whether to allow player use Respec Flask while he is in first room and timer is stopped
  - true - allows to use Respec Flask in first room while timer in vault is stopped.
  - false (default) - no change


## Commands
If `vaultExtraLocalizedGameRules` is set to `true`, you can use the following commands to change the game rules:

- /extra_rules set <rule> <value> - Set the value of a game rule
- /extra_rules local_allowed <rule> <value> - Set the value of a localized game rule

## Local GameRules 
Admins can set local levels for each gamerule. It has 3 values:
- SERVER - the game rule is set by the server. Players cannot set it locally.
- VAULT - the game rule is set for the vault. Rule value is taken from owner and is set to all players inside that vault.
- PLAYER - the game rule is set for the player.

GameRules that are targeted by this feature are:
- vaultExtraCopiouslyDropModifier - (default: VAULT)
- vaultExtraCoinDrops - (default: VAULT)
- vaultExtraCompletionExperienceModifier - (default: PLAYER)
- vaultExtraBonusExperienceModifier - (default: PLAYER)
- vaultExtraReusePedestals - (default: VAULT)
- vaultLoot - (default: VAULT)
- vaultCrystalMode - (default: PLAYER)
- vaultExtraAllowFlasksWhilePause - (default: PLAYER)